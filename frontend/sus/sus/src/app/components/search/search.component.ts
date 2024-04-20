import { Component } from '@angular/core';
import { SearchService } from './service/search.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-search',
  standalone: true,
  imports: [NgIf],
  templateUrl: './search.component.html',
  styleUrl: './search.component.scss'
})
export class SearchComponent {

  patientData: any;

  constructor(private searchService: SearchService) { }


  searchByCPF(cpf: string): void {

    this.searchService.getPatientData(cpf).subscribe(data => {
      this.patientData = data;
    });

    console.log(this.patientData)
  }
}
