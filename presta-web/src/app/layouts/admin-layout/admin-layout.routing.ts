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

export const routes: Routes = [
  { path: "admin-dashboard", component: DashboardComponent },
  { path: "user-profile", component: UserProfileComponent },
  { path: "clients", component: TablesComponent },
  { path: "utilisateurs", component: IconsComponent },
  { path: "type-user", component: MapsComponent },
  { path: "offres-d-emploi", component: CandidaturesComponent },
  { path: "profil", component: ProfilComponent },
  { path: "notification", component: NotifPrestatireComponent },
  { path: "**", component: DashboardComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdminRoutingModule {}
