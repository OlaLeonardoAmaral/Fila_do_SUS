import { NgFor } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from '../header/header.component';
import { LoginService } from './services/login.service';
import { Patient } from './DTOs/patient';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { Hospital } from './DTOs/hospitalName';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [HeaderComponent, NgFor, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})

export class LoginComponent {

  hospitals: Hospital[] = [];
  hospitalSelecionado: string = '';
  toaster = inject(ToastrService);

  constructor(public loginService: LoginService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loginService.getAllHospital().subscribe(data => {
      this.hospitals = data;
    })
  }

  enviarDados(event: Event): void {
    const form = new FormData(event.target as HTMLFormElement);

    const data: Patient = {
      name: form.get('nome') as string,
      age: parseInt(form.get('idade') as string),
      cpf: form.get('cpf') as string,
      gender: form.get('genero')?.valueOf() as string,
      status: "ESPERANDO",
      hospital: {
        hospitalId: parseInt(this.hospitalSelecionado)
      }
    }

    this.loginService.createPatient(data).subscribe({
      complete: () => this.toaster.success('Cadastrado com sucesso!', '', {
        timeOut: 2000,
        positionClass: 'toast-top-center'
      }),
      error: (er) => {
        this.toaster.error('Falha ao cadastrar paciente.', '', {
          timeOut: 3000,
          positionClass: 'toast-top-center'
        })
        console.error(er.error)
      }
    })

  }

  toggleForm() {
    const form = document.querySelector('form');
    if (form) {
      form.animate({ height: 'toggle', opacity: 'toggle' });
    }
  }

}
