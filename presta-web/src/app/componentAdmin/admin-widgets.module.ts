import { RouterModule } from "@angular/router";
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FooterAdminComponent } from "./footer-admin/footer-admin.component";
import { SidebarAdminComponent } from "./sidebar-admin/sidebar-admin.component";
import { NavbarAdminComponent } from "./navbar-admin/navbar-admin.component";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

@NgModule({
  declarations: [
    FooterAdminComponent,
    SidebarAdminComponent,
    NavbarAdminComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [FooterAdminComponent, SidebarAdminComponent, NavbarAdminComponent],
})
export class AdminWidgetsModule {}
