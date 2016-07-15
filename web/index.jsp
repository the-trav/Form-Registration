<%--provided two layers of client side validation.
    html5 and javascript. Javascript can be disabled in browsers and ios mobile safari doesnt support html5 validation.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/registration-styles.css">
        
    </head>
    <body>
        <form class="formStyle" method="POST" action="RegistrationFormServlet">
            <h1>Join The Club &AMP; Sign-Up Now</h1>
            <label for="firstName">
                <span>First name:</span>
                <input id="firstName" name="firstName" placeholder="First Name" type="text" required title="Your First Name. Alphabetic Letters Only" pattern="[a-zA-Z]*" />
            </label>

            <label for="lastName">
                <span>Last Name:</span>
                <input id="lastName" name="lastName" placeholder="Last Name" type="text" required title="Your Last Name. Alphabetic Letters Only" pattern="[a-zA-Z]*"/>
            </label>

            <label for="address">
                <span>Address: </span>
                <input id="address" name="address" placeholder="Address 1" type="text" required title="Your Address. Alphanumeric Characters only" pattern="[a-zA-Z0-9\s]*"/>
            </label>

            <label for="addressOptional">
                <span>Address 2(Optional): </span>
                <input id="addressOptional" name="addressOptional" placeholder="Address 2 (Optional)" title="Your Address. Alphanumeric Characters only or leave blank" type="text" pattern="[a-zA-Z0-9\s]*"/>
            </label>

            <label for="city">
                <span>City: </span>
                <input id="city" name="city" placeholder="City" type="text" required title="The city you resign in. Alphabetic Letters and spaces only" pattern="[a-zA-Z\s]*" />
            </label>

            <label for="state">
                <span>State: </span>
                <select id="state" name="state" required>
                    <option value="Alabama">Alabama</option>
                    <option value="Alaska">Alaska</option>
                    <option value="Arizona">Arizona</option>
                    <option value="Arkansas">Arkansas</option>
                    <option value="California">California</option>
                    <option value="Colorado">Colorado</option>
                    <option value="Connecticut">Connecticut</option>
                    <option value="Delaware">Delaware</option>
                    <option value="Florida">Florida</option>
                    <option value="Georgia">Georgia</option>
                    <option value="Hawaii">Hawaii</option>
                    <option value="Idhao">Idaho</option>
                    <option value="Illinois">Illinois</option>
                    <option value="Indiana">Indiana</option>
                    <option value="Iowa">Iowa</option>
                    <option value="Kansas">Kansas</option>
                    <option value="Kentucky">Kentucky</option>
                    <option value="Louisiana">Louisiana</option>
                    <option value="Maine">Maine</option>
                    <option value="Maryland">Maryland</option>
                    <option value="Massachusetts">Massachusetts</option>
                    <option value="Michigan">Michigan</option>
                    <option value="Minnesota">Minnesota</option>
                    <option value="Mississippi">Mississippi</option>
                    <option value="Missouri">Missouri</option>
                    <option value="Montana">Montana</option>
                    <option value="Nebraska">Nebraska</option>
                    <option value="Nevada">Nevada</option>
                    <option value="New Hampshire">New Hampshire</option>
                    <option value="New Jersey">New Jersey</option>
                    <option value="New Mexico">New Mexico</option>
                    <option value="New York">New York</option>
                    <option value="North Carolina">North Carolina</option>
                    <option value="North Dakota">North Dakota</option>
                    <option value="Ohio">Ohio</option>
                    <option value="Oklahoma">Oklahoma</option>
                    <option value="Oregon">Oregon</option>
                    <option value="Pennsylvania">Pennsylvania</option>
                    <option value="Rhode Island">Rhode Island</option>
                    <option value="South Carolina">South Carolina</option>
                    <option value="South Dakota">South Dakota</option>
                    <option value="Tennessee">Tennessee</option>
                    <option value="Texas">Texas</option>
                    <option value="Utah">Utah</option>
                    <option value="Vermont">Vermont</option>
                    <option value="Virginia">Virginia</option>
                    <option value="Washington">Washington</option>
                    <option value="West Virginia">West Virginia</option>
                    <option value="Wisconsin">Wisconsin</option>
                    <option value="Wyoming">Wyoming</option>
                </select>
            </label>

            <label for="zip">
                <span>Zip Code: </span>
                <input id="zip" name="zip" placeholder="Zip Code" type="text" required pattern="^[0-9]{5}(?:-[0-9]{4})?$"/>
            </label>

            <label for="country">
                <span>Country: </span>
                <input id="country" name="country" value="United States" type="text" readonly />
            </label>

            <input type="submit" class="button" value="send" onclick="validate(this.form)"/>

            <noscript>
            <input type="hidden" name="JavaScript" value="false" />
            </noscript>

        </form>
        
        <script src="js/validate-form.js"></script>
    </body>
</html>
