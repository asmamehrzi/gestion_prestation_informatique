import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class OffreService {
  private baseUrl = "http://localhost:8080/api/v1/missions";

  constructor(private http: HttpClient) {}
  getOffres(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
