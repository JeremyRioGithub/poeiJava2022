import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private _products = [
    {id:1, name:'Voiture'},
    {id:2, name:'Avion'},
  ]

  private _selectedProductId: number | null=null;

  get products(){
    return this._products.map((product) => {return {...product};})
  }

  get selectedProduct(){
    return {...this.products.find((product) => product.id === this._selectedProductId)}
  }

  constructor() { }

  selectProduct(productId:number){
    this._selectedProductId = productId;
  }
}
