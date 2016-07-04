<html>
<head>
    <script
            src="https://code.jquery.com/jquery-3.0.0.min.js"
            integrity="sha256-JmvOoLtYsmqlsWxa7mDSLMwa6dZ9rrIdtrrVYRnDRH0="
            crossorigin="anonymous"></script>
</head>
<body>
<form id="myForm">
    <label> Name
        <input name="name">
    </label>
    <label> Price
        <input name="price">
    </label>
    <button id="submitButton">Save</button>
</form>
<script>
    $("#submitButton").on("click", function (e) {
        e.preventDefault();
        $.ajax({
            url: "/products",
            type: "POST",
            data: $("#myForm").serialize(),
            success: appendToProducts
        });
    });

    $(document).ready(function () {
        $.ajax({
            url: "/products",
            type: "GET",
            success: function (products) {
                products.forEach(appendToProducts)
            }
        });
    });

    function appendToProducts(product) {
        $("#products").append("<p>" + product.name + " ," + product.price + "</p>");
    }
</script>
<div id="products"></div>
</body>
</html>