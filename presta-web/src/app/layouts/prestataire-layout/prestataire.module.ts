import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { PrestataireRoutingModule } from "./prestataire-routing.module";
import { PrestataireLayoutComponent } from "./prestataire-layout.component";
import { DashboardComponent } from "src/app/pages/dashboard/dashboard.component";
import { UserProfileComponent } from "src/app/pages/user-profile/user-profile.component";
import { TablesComponent } from "src/app/pages/tables/tables.component";
import { IconsComponent } from "src/app/pages/icons/icons.component";
import { MapsComponent } from "src/app/pages/maps/maps.component";
import { CandidaturesComponent } from "src/app/pages/candidatures/candidatures.component";

@NgModule({
  declarations: [
    DashboardComponent,
    UserProfileComponent,
    TablesComponent,
    IconsComponent,
    MapsComponent,
    CandidaturesComponent,
  ],
  imports: [CommonModule, PrestataireRoutingModule],
  exports: [
    DashboardComponent,
    UserProfileComponent,
    TablesComponent,
    IconsComponent,
    MapsComponent,
    CandidaturesComponent,
  ],
})
export class PrestataireModule {}
