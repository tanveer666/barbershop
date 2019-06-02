/** AJAX REQUESTS */
function getData(location, element_id, render) {
    $.ajax({
        url: "/customer" + location,
        success: function (reqBody) {
            display(reqBody, element_id, render);
        }
    });

}

function postData(body) {
    $.ajax({
            url: "/customer",
            method: "POST",
            contentType: "application/json",
            data: body,
            success: function (reqBody) {
                $("#price").append(reqBody+"€");
                fetchData();
            }

        }
    )
}

/** DISPLAY FUNCTION
 * TAKES IN AN OBJECT amd LIST OF PROPERTIES OF THAT OBJECT TO DISPLAY ON THE HTML PAGE */
function display(reqBody, id, objProperties) {

    let size = objProperties.length;
    console.log(size);
    $(id).text("");
    for (let i in reqBody) {

        let obj = reqBody[i];
        let str = " ";

        for(let j = 0; j < size; j++) {
           let key = objProperties[j];
           str = "" + key + ":  &emsp; " + obj[key] +" &emsp; " ;
           console.log( obj[key] );
           $(id).append(str);
       }


        $(id).append("<br>");
        console.log("What in the name of fuck");
    }
}

/* ACTUAL FUNCTION TO CALL THE GET REQUESTS WITH APPROPRIATE DIRECTORY
 * AND PARAMETERS FOR DISPLAY FUNCTION */

function fetchData () {
    let id1 = "#haircuts";
    let keyArr = ["hairCutName","hairCutPrice"];
    getData("/service", id1, keyArr);

    let id2 = "#freeDates";
    let keyArr2 = ["reservationDate", "reservationTime", "id"];
    getData("/dates",id2,keyArr2);

}

let customer = {};

$(document).ready(fetchData);

/* TAKES DATA FROM THE FORM, CREATES A CUSTOMER OBJECT AND SENDS THE POST REQUEST */
$("#submit").click(function (event) {
    console.log(event);
    event.preventDefault();

    customer.name = $("#name").val();
    customer.hairCutID = $("#service").val();
    customer.reservationDateID = $("#date").val();
    customer.customerID = null;
    customer.phoneNum = $("#phoneNum").val();
    console.log((customer));
    let responseBody = JSON.stringify(customer);
    postData(responseBody);

});

