import { NgFor, NgIf } from '@angular/common';
import { Component, inject } from '@angular/core';
import { SearchService } from './service/search.service';
import { DeleteService } from './service/delete.service';
import { ToastrService } from 'ngx-toastr';
import { GetAllHospitalsService } from './service/getAllHospitals.service';
import { Hospital } from '../login/DTOs/hospitalName';
import { FormsModule, NgForm } from '@angular/forms';
import { PatientDTO } from './DTOs/patientDTO';
import { Patient } from '../login/DTOs/patient';
import { EditService } from './service/edit.service';

@Component({
  selector: 'app-search',
  standalone: true,
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './search.component.html',
  styleUrl: './search.component.scss'
})
export class SearchComponent {
  hospitals: Hospital[] = [];
  showPopUp = false;
  patientData: any;
  selectedHospitalId: string = '';
  toaster = inject(ToastrService);

  constructor(public getAllHospitalsService: GetAllHospitalsService,
    private searchService: SearchService,
    private deleteService: DeleteService,
    private editService: EditService) { }


    ngOnInit(): void {
      this.getAllHospitalsService.getAllHospitals().subscribe(data => {
        this.hospitals = data;
      });
    }


  searchByCPF(cpf: string): void {

    this.searchService.getPatientData(cpf).subscribe(data => {
      this.patientData = data;
      this.selectedHospitalId = this.patientData.hospital.id;
    });

    // console.log(this.patientData)
  }

  deletePatient(patientId: String): void {
    this.deleteService.deletePatient(patientId).subscribe({
      complete: () => {
        this.toaster.success('Deletado com sucesso!', '', {
          timeOut: 2000,
          positionClass: 'toast-top-center'
        });
        setTimeout(() => {
          window.location.reload();
        }, 2000);
      },

      error: (er) => {
        this.toaster.error('Falha ao deletar paciente.', '', {
          timeOut: 3000,
          positionClass: 'toast-top-center'
        })
        console.error(er.error)
      }
    })
  }



  editPatient(form: NgForm): void {
    const updatedPatient: Patient = {
      name: this.patientData.name,
      age: parseInt(this.patientData.age),
      cpf: this.patientData.cpf,
      gender: this.patientData.gender,
      status: "ESPERANDO",
      hospital: {
        hospitalId: parseInt(this.selectedHospitalId)
      }
    };

    const idPatient: number = this.patientData.patientId;

    this.editService.editPatient(idPatient, updatedPatient).subscribe({
      complete: () => this.toaster.success('Editado com sucesso!', '', {
        timeOut: 2000,
        positionClass: 'toast-top-center'
      }),
      error: er => {
        this.toaster.error('Falha ao editar paciente.', '', {
          timeOut: 3000,
          positionClass: 'toast-top-center'
        });
        console.error(er.error);
      }
    });

  }



  togglePopUp() {
    this.showPopUp = !this.showPopUp;
  }
}
