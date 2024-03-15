import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from '../header/header.component';
import { LoginService } from './services/login.service';
import { Patient } from './services/patient';

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

    const data: Patient = {
      name: form.get('nome') as string,
      age: parseInt(form.get('idade') as string),
      cpf: form.get('cpf') as string,
      gender: "Masculino",
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
