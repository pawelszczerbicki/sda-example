<html>

<body>
<form id="myForm" action="/products" method="post">
    <label> Name
        <input name="name">
    </label>
    <label> Price
        <input name="price">
    </label>
    <button id="submitButton">Save</button>
</form>
<script>
    $("#submitButton").on("click", function () {
        $.ajax({
            url: "/products",
            type: "POST",
            data: $("#myForm").serialize(),
            success: function (product) {
                $("#products").html("<p>" + product.name + " ," + product.price + "</p>");
            }
        });


    })
</script>
<div id="products"></div>
</body>
</html>