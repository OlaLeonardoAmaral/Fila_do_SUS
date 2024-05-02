import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, catchError, map } from "rxjs";

@Injectable({
    providedIn: 'root'
})

export class LoginService {

    private apiURL = "http://localhost:8080";

    constructor(private httpClient: HttpClient) { }

    getAllHospital(): Observable<any> {
        return this.httpClient.get(this.apiURL + "/hospital")
            .pipe(
                map((response: any) => response.hospitals)
            );
    }

    createPatient(data: any): Observable<any> {
        return this.httpClient.post(this.apiURL + "/patient/create", data);
    }

}