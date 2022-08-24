import { AjouterCandidatureComponent } from "./../../pages/ajouter-Candidature/ajouter-candidature.component";
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AddProfilComponent } from "src/app/pages/add-profil/add-profil.component";
import { CandidaturesComponent } from "src/app/pages/candidatures/candidatures.component";
import { DashboardComponent } from "src/app/pages/dashboard/dashboard.component";
import { IconsComponent } from "src/app/pages/icons/icons.component";
import { MapsComponent } from "src/app/pages/maps/maps.component";
import { NotifPrestatireComponent } from "src/app/pages/notif-prestatire/notif-prestatire.component";
import { ProfilComponent } from "src/app/pages/profil/profil.component";
import { TablesComponent } from "src/app/pages/tables/tables.component";
import { UpdateProfilComponent } from "src/app/pages/update-profil/update-profil.component";
import { UserProfileComponent } from "src/app/pages/user-profile/user-profile.component";

const routes: Routes = [
  { path: "dashboard", component: DashboardComponent },
  { path: "user-profile", component: UserProfileComponent },
  { path: "tables", component: TablesComponent },
  { path: "offres-d-emploi", component: IconsComponent },
  { path: "maps", component: MapsComponent },
  { path: "candidature", component: CandidaturesComponent },
  { path: "profil", component: ProfilComponent },
  { path: "notification", component: NotifPrestatireComponent },
  { path: "addprofil", component: AddProfilComponent },
  { path: "addCandidature", component: AjouterCandidatureComponent },
  { path: "update/:id", component: UpdateProfilComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PrestataireRoutingModule {}
