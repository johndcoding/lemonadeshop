
function refreshDisplay(){
    if($("[name='creerNouveauClient']:checked").val()==="true"){
        $("[name='clientExistant']").hide();
        $("#formClient").show();
    }else{
        $("[name='clientExistant']").show();
        $("#formClient").hide();
    }
}


$(document).ready(function(){
    refreshDisplay();
    $("[name='creerNouveauClient']").on("change", refreshDisplay);
});