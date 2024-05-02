import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})

export class SearchService {
    private apiURL = "http://localhost:8080/patient";

    constructor(private httpClient: HttpClient) { }

    getPatientData(cpf: string): Observable<any> {
        return this.httpClient.get(`${this.apiURL}/cpf`, {params: {cpf}});
    }
}