import { ProfilService } from "src/app/services/profil.service";
import { CandidatureServiceService } from "./../../services/candidature-service.service";
import { CampetanceServiceService } from "./../../services/campetance-service.service";
import { ViewChild, Component, OnInit } from "@angular/core";
import { NgbModal, ModalDismissReasons } from "@ng-bootstrap/ng-bootstrap";

import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormArray,
  FormGroupDirective,
  FormControl,
} from "@angular/forms";
import { ToastrService } from "ngx-toastr";
import { Competance } from "src/app/Model/Competance";
import { Candidature } from "src/app/Model/Candidature";
import { Profil } from "src/app/Model/Profil";
import { Observable } from "rxjs";
@Component({
  selector: "app-ajouter-candidature",
  templateUrl: "./ajouter-candidature.component.html",
  styleUrls: ["./ajouter-candidature.component.css"],
})
export class AjouterCandidatureComponent implements OnInit {
  // closeResult: string;

  closeResult = "";
  profils: Observable<Profil[]>;
  /****addCompCandidature */
  public comps: Competance[] = [];
  public candidatures: Candidature[] = [];
  public cand: Candidature[] = [];

  competanceForm = new FormGroup({
    nom: new FormControl("", Validators.required),
    prenom: new FormControl("", Validators.required),
    telephone: new FormControl("", Validators.required),
    description: new FormControl("", Validators.required),
    comp: new FormControl("", Validators.required),
  });
  //-----------------//
  form!: FormGroup;
  newComp = {
    id: 0,
    titre: "",
    description: "",
  };
  /********* */
  compList = [];
  clicked = false;
  /***/
  candidatureForm = new FormGroup({
    titre: new FormControl(""),
    description: new FormControl(""),
    comp: new FormControl(""),
  });
  constructor(
    private fb: FormBuilder,
    private modalService: NgbModal,
    private competanceService: CampetanceServiceService,
    private profilService: ProfilService,
    private candidatureService: CandidatureServiceService,
    private http: HttpClient,
    private toastr: ToastrService
  ) {
    //this.profils = [];
    this.candidatures = [];
    this.competanceService.getcompetanceList;
    this.candidatureForm = this.fb.group({
      nom: "",
      prenom: "",
      email: "",
      telephone: "",
      description: "",
      comp: this.fb.array([]),
    });
  }

  prod(): FormArray {
    return this.competanceForm.get("comp") as FormArray;
  }
  openLg(content) {
    this.modalService.open(content, { size: "lg" });
  }
  displayStyle = "none";

  openPopup() {
    this.displayStyle = "block";
  }
  closePopup() {
    this.displayStyle = "none";
  }
  actionMethod() {
    //event.target.disabled = true;
    console.log("actionMethod was called!");
  }
  open(content) {
    this.modalService
      .open(content, { ariaLabelledBy: "modal-basic-title" })
      .result.then(
        (result) => {
          this.closeResult = `Closed with: ${result}`;
        },
        (reason) => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return "by pressing ESC";
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return "by clicking on a backdrop";
    } else {
      return `with: ${reason}`;
    }
  }
  ngOnInit(): void {
    // this.getCompetances();
    this.getListProfils();
  }
  submit() {
    console.log("submitted");
  }
  public getListProfils(): void {
    this.profilService.getcompetanceList().subscribe((data) => {
      this.profils = data;
      alert(data);
      console.log(data);
    });
  }
  /* getProd(produit: Produit) {
    this.newProd = produit;
  }*/
  public addProdToCatalogue(pro) {
    //console.log(this.prods);
    this.compList.push(pro);
    console.log(this.compList);

    // alert(this.prodList);

    //this.prods.push(this.prodss);
  }
  ondeleteL(item) {
    this.compList.splice(item, 1);
  }
  reset() {
    this.candidatureForm.setValue({
      nom: "",
      prenom: "",
      telephone: "",
      description: "",
    });
  }
  onSubmit() {
    //console.log(this.productForm.value);
    this.competanceForm.value.comp = this.compList;
    // console.log(this.prodList);
    console.log(this.competanceForm.value);
    this.candidatureService
      .createCandidature(this.competanceForm.value)
      .subscribe((response: Candidature) => {
        console.log(response);
        this.getCandidatures();
        this.competanceForm.reset();
        this.toastr.success("New row added successfully", "New Row");
      });
  }
  getCandidatures() {}
}
