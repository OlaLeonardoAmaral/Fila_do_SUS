import { Component, NgModule } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { LoginService } from './services/login.service';
import { NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [HeaderComponent, NgFor, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})

export class LoginComponent {

  hospitals: any[] = [];
  hospitalSelecionado: string = '';

  constructor(public loginService: LoginService) { }

  ngOnInit(): void {
    this.loginService.getAllHospital().subscribe(data => {
      this.hospitals = data;
    })
  }

  enviarDados(event: Event): void {
    event.preventDefault();

    const form = new FormData(event.target as HTMLFormElement);

    const data = {
      name: form.get('nome') as string,
      age: parseInt(form.get('idade') as string),
      cpf: form.get('cpf') as string,
      sexo: "Masculino",
      status: "ESPERANDO",
      hospital: {
        hospitalId: parseInt(this.hospitalSelecionado)
      }
    }
    this.loginService.createPatient(data).subscribe(response => {
      console.log(response);
    }, error => {
      console.error(error);
    })
  }

  toggleForm() {
    const form = document.querySelector('form');
    if (form) {
      form.animate({ height: 'toggle', opacity: 'toggle' });
    }
  }
}
