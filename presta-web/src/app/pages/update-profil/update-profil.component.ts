import { ProfilService } from "./../../services/profil.service";
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Profil } from "src/app/Model/Profil";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-update-profil",
  templateUrl: "./update-profil.component.html",
  styleUrls: ["./update-profil.component.css"],
})
export class UpdateProfilComponent implements OnInit {
  id: number;
  profil: Profil;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private ProfilService: ProfilService
  ) {}

  ngOnInit(): void {
    this.profil = new Profil();

    this.id = this.route.snapshot.params["id"];

    this.ProfilService.getCompetance(this.id).subscribe(
      (data) => {
        console.log(data);
        this.profil = data;
      },
      (error) => console.log(error)
    );
  }
  updateProfil() {
    this.ProfilService.updatecompetance(this.id, this.profil).subscribe(
      (data) => {
        console.log(data);
        this.profil = new Profil();
        this.gotoList();
      },
      (error) => console.log(error)
    );
  }
  onSubmit() {
    this.updateProfil();
  }
  gotoList() {
    this.router.navigate(["profil"]);
  }
}
