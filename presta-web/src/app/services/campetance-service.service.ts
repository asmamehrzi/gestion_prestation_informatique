import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class CampetanceServiceService {
  private baseUrl = "http://localhost:8080/api/v1/competances";

  constructor(private http: HttpClient) {}
  getCompetance(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createCompetance(competance: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, competance);
  }

  updatecompetance(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deletecompetance(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: "text" });
  }

  getcompetanceList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
