import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  {
    path: "/client/client-dashboard",
    title: "Dashboard",
    icon: "ni-tv-2 text-primary",
    class: "",
  },
  {
    path: "/client/offres-d-emploi",
    title: "Offres d'emploi",
    icon: "ni-planet text-blue",
    class: "",
  },
  {
    path: "/client/profil",
    title: "Profil",
    icon: "ni-pin-3 text-orange",
    class: "",
  },
  {
    path: "/client/user-profile",
    title: "Utilisateur",
    icon: "ni-single-02 text-yellow",
    class: "",
  },
  {
    path: "/client/notification",
    title: "Notification",
    icon: "ni-bullet-list-67 text-red",
    class: "",
  },
];

@Component({
  selector: "app-sidebar-client",
  templateUrl: "./sidebar-client.component.html",
  styleUrls: ["./sidebar-client.component.css"],
})
export class SidebarClientComponent implements OnInit {
  public menuItems: any[];
  public isCollapsed = true;

  constructor(private router: Router) {}

  ngOnInit() {
    this.menuItems = ROUTES.filter((menuItem) => menuItem);
    this.router.events.subscribe((event) => {
      this.isCollapsed = true;
    });
  }
}
