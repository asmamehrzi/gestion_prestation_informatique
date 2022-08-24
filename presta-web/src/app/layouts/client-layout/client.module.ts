import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { ClientLayoutComponent } from "./client-layout.component";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { ClipboardModule } from "ngx-clipboard";
import { RouterModule } from "@angular/router";
import { ClientWidgetsModule } from "src/app/component-client/client-widgets.module";
import { ClientRoutingModule } from "./client-routing.module";

@NgModule({
  declarations: [],
  imports: [CommonModule, ClientRoutingModule],
  exports: [],
})
export class ClientModule {}
