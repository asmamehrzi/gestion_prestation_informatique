import { ClientLayoutComponent } from "./layouts/client-layout/client-layout.component";
import { PrestataireLayoutComponent } from "./layouts/prestataire-layout/prestataire-layout.component";
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";

import { AdminLayoutComponent } from "./layouts/admin-layout/admin-layout.component";
import { AuthLayoutComponent } from "./layouts/auth-layout/auth-layout.component";

const routes: Routes = [
  {
    path: "admin",
    component: AdminLayoutComponent,
    children: [
      {
        path: "",
        loadChildren: () =>
          import("src/app/layouts/admin-layout/admin-layout.module").then(
            (m) => m.AdminLayoutModule
          ),
      },
    ],
  },
  {
    path: "prestataire",
    component: PrestataireLayoutComponent,
    children: [
      {
        path: "",
        loadChildren: () =>
          import("src/app/layouts/prestataire-layout/prestataire.module").then(
            (m) => m.PrestataireModule
          ),
      },
    ],
  },
  {
    path: "client",
    component: ClientLayoutComponent,
    children: [
      {
        path: "",
        loadChildren: () =>
          import("src/app/layouts/client-layout/client.module").then(
            (m) => m.ClientModule
          ),
      },
    ],
  },
  {
    path: "**",
    redirectTo: "client",
    pathMatch: "full",
  },
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true,
    }),
  ],
  exports: [],
})
export class AppRoutingModule {}
