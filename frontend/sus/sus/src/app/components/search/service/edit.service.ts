import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, catchError, map } from "rxjs";

@Injectable({
    providedIn: 'root'
})

export class EditService {

    private apiURL = "http://localhost:8080/patient";

    constructor(private httpClient: HttpClient) { }

    editPatient(patientId: number, data: any): Observable<any> {
        return this.httpClient.put(`${this.apiURL}/${patientId}`, data);
    }

}