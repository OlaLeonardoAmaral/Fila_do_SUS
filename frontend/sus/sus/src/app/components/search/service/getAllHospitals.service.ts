import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, catchError, map } from "rxjs";

@Injectable({
    providedIn: 'root'
})

export class GetAllHospitalsService {

    private apiURL = "http://localhost:8080";

    constructor(private httpClient: HttpClient) { }

    getAllHospitals(): Observable<any> {
        return this.httpClient.get(this.apiURL + "/hospital")
            .pipe(
                map((response: any) => response.hospitals)
            );
    }

}