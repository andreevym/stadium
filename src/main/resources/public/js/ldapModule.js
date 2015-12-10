(function(){
    var app = angular.module('ldap', []);

    app.controller('LdapController', function(){
        this.users = users;
    });

    var users = [
        {
            name: "Dodecahedron",
            price: 2.95,
            description: ". . .",
            canPurchase: true,
        },
        {
            name: "Pentagonal Gem",
            price: 5.95,
            description: ". . .",
            canPurchase: false,
        }
    ];
})();

loadUsers()