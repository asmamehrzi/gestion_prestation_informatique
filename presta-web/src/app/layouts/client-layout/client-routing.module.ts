import { UpdateProfilComponent } from "./../../pages/update-profil/update-profil.component";
import { NotifPrestatireComponent } from "./../../pages/notif-prestatire/notif-prestatire.component";
import { ProfilComponent } from "./../../pages/profil/profil.component";
import { RouterModule, Routes } from "@angular/router";
import { AddProfilComponent } from "./../../pages/add-profil/add-profil.component";

import { DashboardComponent } from "../../pages/dashboard/dashboard.component";
import { IconsComponent } from "../../pages/icons/icons.component";
import { MapsComponent } from "../../pages/maps/maps.component";
import { UserProfileComponent } from "../../pages/user-profile/user-profile.component";
import { TablesComponent } from "../../pages/tables/tables.component";
import { CandidaturesComponent } from "src/app/pages/candidatures/candidatures.component";
import { NgModule } from "@angular/core";
import { AjouterOffreComponent } from "src/app/component-client/ajouter-offre/ajouter-offre.component";

export const routes: Routes = [
  { path: "client-dashboard", component: AjouterOffreComponent },
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClientRoutingModule {}
