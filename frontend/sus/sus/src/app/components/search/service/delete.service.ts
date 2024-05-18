import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})

export class DeleteService {
    private apiURL = "http://localhost:8080/patient";

    constructor(private httpClient: HttpClient) { }

    deletePatient(patientId: String): Observable<any> {
        return this.httpClient.delete(`${this.apiURL}/${patientId}`);
    }
}