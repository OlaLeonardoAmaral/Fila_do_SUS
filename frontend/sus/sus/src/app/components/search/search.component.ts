import { NgIf } from '@angular/common';
import { Component, inject } from '@angular/core';
import { SearchService } from './service/search.service';
import { DeleteService } from './service/delete.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-search',
  standalone: true,
  imports: [NgIf],
  templateUrl: './search.component.html',
  styleUrl: './search.component.scss'
})
export class SearchComponent {
  showPopUp = false;
  patientData: any;
  toaster = inject(ToastrService);

  constructor(private searchService: SearchService,
    private deleteService: DeleteService) { }

  searchByCPF(cpf: string): void {

    this.searchService.getPatientData(cpf).subscribe(data => {
      this.patientData = data;
    });

    console.log(this.patientData)
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

  togglePopUp() {
    this.showPopUp = !this.showPopUp;
  }
}
