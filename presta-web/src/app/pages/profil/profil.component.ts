import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { Profil } from "src/app/Model/Profil";
import { ProfilService } from "src/app/services/profil.service";

@Component({
  selector: "app-profil",
  templateUrl: "./profil.component.html",
  styleUrls: ["./profil.component.css"],
})
export class ProfilComponent implements OnInit {
  profils: Observable<Profil[]>;

  constructor(private profilservice: ProfilService, private router: Router) {}

  ngOnInit(): void {
    this.getCompetances();
  }
  getCompetances() {
    this.profilservice.getcompetanceList().subscribe((data) => {
      this.profils = data;
    });
  }
  deleteProfil(id: number) {
    this.profilservice.deletecompetance(id).subscribe(
      (data) => {
        console.log(data);
        this.router.navigate(["profil"]);
        this.getCompetances();
      },
      (error) => console.log(error)
    );
  }
}
