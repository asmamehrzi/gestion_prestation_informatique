import { AdminWidgetsModule } from "./../../componentAdmin/admin-widgets.module";
import { CandidaturesComponent } from "./../../pages/candidatures/candidatures.component";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";
import { CommonModule } from "@angular/common";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

import { ClipboardModule } from "ngx-clipboard";

import { AdminRoutingModule } from "./admin-layout.routing";
import { DashboardComponent } from "../../pages/dashboard/dashboard.component";
import { IconsComponent } from "../../pages/icons/icons.component";
import { MapsComponent } from "../../pages/maps/maps.component";
import { UserProfileComponent } from "../../pages/user-profile/user-profile.component";
import { TablesComponent } from "../../pages/tables/tables.component";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
// import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    //DashboardComponent,
    // UserProfileComponent,
    // TablesComponent,
    // IconsComponent,
    // MapsComponent,
    // CandidaturesComponent,
  ],
  imports: [CommonModule, AdminRoutingModule],
  exports: [
    //DashboardComponent,
    // UserProfileComponent,
    // TablesComponent,
    // IconsComponent,
    // MapsComponent,
    //CandidaturesComponent,
  ],
})
export class AdminLayoutModule {}
