import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FooterClientComponent } from "./footer-client/footer-client.component";
import { NavbarClientComponent } from "./navbar-client/navbar-client.component";
import { SidebarClientComponent } from "./sidebar-client/sidebar-client.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { RouterModule } from "@angular/router";
import { AjouterOffreComponent } from "./ajouter-offre/ajouter-offre.component";

@NgModule({
  declarations: [
    FooterClientComponent,
    NavbarClientComponent,
    SidebarClientComponent,
    AjouterOffreComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [
    FooterClientComponent,
    SidebarClientComponent,
    NavbarClientComponent,
  ],
})
export class ClientWidgetsModule {}
