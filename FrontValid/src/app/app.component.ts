import { Component } from "@angular/core";
import { ClientService } from "./services/client.service";
import { ClienteDTO } from "./dto/client.dto";
import { ClientEntity } from "./dto/client.entity";
import { MatTableDataSource } from "@angular/material";
import { SelectionModel } from "@angular/cdk/collections";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = "FrontValid";

  clientDtoArr: ClienteDTO[] = new Array<ClienteDTO>();
  clientlst: ClienteDTO[] = new Array<ClienteDTO>();
  clientDto: ClienteDTO = new ClienteDTO();
  clientCrear: ClientEntity = new ClientEntity();
  objeto: ClientEntity[] = [];

  // tslint:disable-next-line: max-line-length
  displayedColumns: string[] = [
    "accion",
    "Id",
    "Name",
    "LastName",
    "Processed"
  ];
  consultaSol: ClientEntity[] = new Array<ClientEntity>();
  dataSource = new MatTableDataSource<ClientEntity>();
  selection = new SelectionModel<ClientEntity>(true, []);

  constructor(private service: ClientService) {
    this.obtenerPersonas();
  }

  seleccionarTodo() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  toggle() {
    this.seleccionarTodo()
      ? this.selection.clear()
      : this.dataSource.data.forEach(row => {
          console.log(row);
          this.selection.select(row);
        });
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: ClientEntity): string {
    if (!row) {
      return `${this.seleccionarTodo() ? "select" : "deselect"} all`;
    }
    return `${
      this.selection.isSelected(row) ? "deselect" : "select"
    } row ${row.id + 1}`;
  }

  obtenerPersonas() {
    this.service
      .getClients("/client/find-all-client")
      .subscribe((personas: any) => {
        this.consultaSol = personas;
        this.dataSource = new MatTableDataSource<ClientEntity>(
          this.consultaSol
        );
      });
  }

  public procesar() {
    this.selection.selected.forEach((value, item) => {
      this.selection.selected[item].processed = true;
    });

    this.service
      .putQuery("/client/saves-clients", this.selection.selected)
      .subscribe((ans: any) => {
        this.obtenerPersonas();
      });
  }

  public crearPersona() {
    const objeto = {
      name: this.clientCrear.name,
      lastName: this.clientCrear.lastName,
      processed: false
    };

    this.service
      .saveClients("/client/save-client", objeto)
      .subscribe((ans: any) => {
        this.obtenerPersonas();
      });
  }
}
