import { OffreService } from "./../../services/offre.service";
import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Offre } from "src/app/Model/Offres";
import { Router } from "@angular/router";

@Component({
  selector: "app-icons",
  templateUrl: "./icons.component.html",
  styleUrls: ["./icons.component.scss"],
})
export class IconsComponent implements OnInit {
  public copy: string;
  offres: Observable<Offre[]>;

  constructor(private offreservice: OffreService, private router: Router) {}

  ngOnInit(): void {
    this.getOffres();
  }
  getOffres() {
    this.offreservice.getOffres().subscribe((data) => {
      this.offres = data;
    });
  }
}
