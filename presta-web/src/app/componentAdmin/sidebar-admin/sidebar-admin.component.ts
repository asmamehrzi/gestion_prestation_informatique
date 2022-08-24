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
    path: "/admin/dashboard",
    title: "admin-dashboard",
    icon: "ni-tv-2 text-primary",
    class: "",
  },
  {
    path: "/admin/offres-d-emploi",
    title: "Offres d'emploi",
    icon: "ni-planet text-blue",
    class: "",
  },

  {
    path: "/admin/user-profile",
    title: "Utilisateur",
    icon: "ni-single-02 text-yellow",
    class: "",
  },
  {
    path: "/admin/clients",
    title: "Client",
    icon: "ni-bullet-list-67 text-red",
    class: "",
  },
  {
    path: "/admin/type-user",
    title: "Type utilisateur",
    icon: "ni-key-25 text-info",
    class: "",
  },
  {
    path: "/admin/profil",
    title: "Profil",
    icon: "ni-circle-08 text-pink",
    class: "",
  },
  {
    path: "/admin/notification",
    title: "Notification",
    icon: "ni-bell-55 text-pink",
    class: "",
  },
];

@Component({
  selector: "app-sidebar-admin",
  templateUrl: "./sidebar-admin.component.html",
  styleUrls: ["./sidebar-admin.component.css"],
})
export class SidebarAdminComponent implements OnInit {
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
