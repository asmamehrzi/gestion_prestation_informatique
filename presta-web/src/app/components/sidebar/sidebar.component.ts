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
    path: "/prestataire/dashboard",
    title: "Dashboard",
    icon: "ni-tv-2 text-primary",
    class: "",
  },
  {
    path: "/prestataire/offres-d-emploi",
    title: "Offres d'emploi",
    icon: "ni-planet text-blue",
    class: "",
  },
  {
    path: "/prestataire/maps",
    title: "Consultant",
    icon: "ni-pin-3 text-orange",
    class: "",
  },
  {
    path: "/prestataire/user-profile",
    title: "User profile",
    icon: "ni-single-02 text-yellow",
    class: "",
  },
  {
    path: "/prestataire/tables",
    title: "Client",
    icon: "ni-bullet-list-67 text-red",
    class: "",
  },
  {
    path: "/prestataire/candidature",
    title: "Candidature",
    icon: "ni-key-25 text-info",
    class: "",
  },
  {
    path: "/prestataire/addCandidature",
    title: "Ajouter candidature",
    icon: "ni-key-25 text-info",
    class: "",
  },
  {
    path: "/prestataire/profil",
    title: "Profil",
    icon: "ni-circle-08 text-pink",
    class: "",
  },
  {
    path: "/prestataire/notification",
    title: "Notification",
    icon: "ni-bell-55 text-pink",
    class: "",
  },
];

@Component({
  selector: "app-sidebar",
  templateUrl: "./sidebar.component.html",
  styleUrls: ["./sidebar.component.scss"],
})
export class SidebarComponent implements OnInit {
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
