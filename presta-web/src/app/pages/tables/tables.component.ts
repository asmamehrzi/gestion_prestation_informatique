import { ClientService } from "./../../services/client.service";
import { Client } from "./../../Model/Client";
import { Observable } from "rxjs";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-tables",
  templateUrl: "./tables.component.html",
  styleUrls: ["./tables.component.scss"],
})
export class TablesComponent implements OnInit {
  clients: Observable<Client[]>;

  constructor(private clientservice: ClientService, private router: Router) {}

  ngOnInit(): void {
    this.getOffres();
  }
  getOffres() {
    this.clientservice.getClients().subscribe((data) => {
      this.clients = data;
    });
  }
}
