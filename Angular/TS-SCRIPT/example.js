// fonctions
var myNum = 3;
function addOne(num) {
    return num + 1;
}
console.log(myNum);
// types
var myString = 'TypeScript';
var myNumber = 10;
var myNum2 = myNumber - 2;
var myBoolean = false;
console.log(myString);
var myArrayOfStrings = ['Angular', 'TypeScript'];
var myNum3 = 3;
//myNum3 = 'coucou'; // Erreur: la variable myNum3 est deja déclarée avec un type number par défaut.
// objet non typé
var myObj = {
    course: 'Angular',
    section: 'TS',
    year: 2022,
    isEasy: true
};
// objet typé, ici c'est "any"
var myObjTypé;
myObjTypé = {
    course: 'Angular',
    section: 'TS',
    year: 2022,
    isEasy: true
};
//interface myObjTypé = { // interface est un peu comme type. Sert à typer les attributs d'un objet.
//contrairement à une classe, ne peut etre instancié et n'a pas de constructeur.
var myObjTypé2 = /** @class */ (function () {
    function myObjTypé2() {
    }
    return myObjTypé2;
}());
var medor = {
    id: 1,
    name: 'Medor',
    species: 'dog'
};
console.log(medor);
var Rabbit = /** @class */ (function () {
    function Rabbit(rabbitId, rabbitName) {
        this.id = rabbitId;
        this.name = rabbitName;
        this.species = 'rabbit';
    }
    return Rabbit;
}());
var roger = new Rabbit(1, 'roger');
console.log(roger);
//=====================================
var Car = /** @class */ (function () {
    function Car(brand) {
        this.brand = brand;
    }
    return Car;
}());
var myCar = new Car('Renault');
console.log(myCar.brand);
