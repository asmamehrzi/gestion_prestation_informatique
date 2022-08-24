import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class CandidatureServiceService {
  private baseUrl = "http://localhost:8080/api/v1/condidatures";

  constructor(private http: HttpClient) {}
  getCandidature(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createCandidature(candidature: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, candidature);
  }

  updateCandidature(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteCandidature(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: "text" });
  }

  getCandidatures(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
