import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class ClientService {
  private baseUrl = "http://localhost:8080/api/v1/clients";

  constructor(private http: HttpClient) {}
  getClients(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
