function validate(form)
{
    var fname = form.firstName.value;
    var lname = form.lastName.value;
    var address1 = form.address.value;
    var cty = form.city.value;
    var zipcode = form.zip.value;

    var alphabetic = /^[a-zA-Z]+$/;
    var alphabetic_with_spaces = /^[a-zA-Z\s]+$/;
    var alphanumeric_with_spaces = /^[A-Za-z0-9 ]+$/;
    var zipcode_validate = /^[0-9]{5}(?:-[0-9]{4})+$/;
    if (!alphabetic.test(fname))
    {
        alert("Please fill in your first name alphabetic characters only");
        form.firstName.focus();
    } else if (!alphabetic.test(lname))
    {
        alert("Please fill in your last name alphabetic characters only");
        form.lastName.focus();
    } else if (!alphanumeric_with_spaces.test(address1))
    {
        alert("Please fill in your address alphanumeric characters only");
        form.address.focus();
    } else if (!alphabetic_with_spaces.test(cty))
    {
        alert("Please fill in your city alphabetic characters and spaces only");
        form.city.focus();
    } else if (!zipcode_validate(zipcode))
    {
        alert("Please fill in your zip code format XXXXX or XXXXX-XXXX");
        form.zip.focus();
    } else
    {
        form.submit();
    }
}