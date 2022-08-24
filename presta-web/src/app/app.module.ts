import { DashboardComponent } from "src/app/pages/dashboard/dashboard.component";
import { CandidaturesComponent } from "src/app/pages/candidatures/candidatures.component";
import { ClientLayoutComponent } from "./layouts/client-layout/client-layout.component";
import { AdminWidgetsModule } from "./componentAdmin/admin-widgets.module";
import { PrestataireLayoutComponent } from "./layouts/prestataire-layout/prestataire-layout.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";

import { AppComponent } from "./app.component";
import { AdminLayoutComponent } from "./layouts/admin-layout/admin-layout.component";
import { AuthLayoutComponent } from "./layouts/auth-layout/auth-layout.component";

import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

import { AppRoutingModule } from "./app.routing";
import { ComponentsModule } from "./components/components.module";
import { UpdateProfilComponent } from "./pages/update-profil/update-profil.component";
import { ClientWidgetsModule } from "./component-client/client-widgets.module";
import { AjouterCandidatureComponent } from './pages/ajouter-Candidature/ajouter-candidature.component';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ComponentsModule,
    NgbModule,
    RouterModule,
    AppRoutingModule,
    AdminWidgetsModule,
    ClientWidgetsModule,
  ],
  declarations: [
    AppComponent,
    PrestataireLayoutComponent,
    AdminLayoutComponent,
    AuthLayoutComponent,
    ClientLayoutComponent,
    UpdateProfilComponent,
    AjouterCandidatureComponent,
    //CandidaturesComponent,
    //DashboardComponent,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
