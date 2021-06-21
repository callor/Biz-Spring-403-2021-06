document.addEventListener("DOMContentLoaded", () => {
  let modal = document.querySelector("div#modal");
  modal.querySelector("span").addEventListener("click", (e) => {
    modal.style.display = "none";
  });
  document.querySelector("form#book_input").addEventListener("keydown", (e) => {
    let key = e.key;
    let tagName = e.target.tagName;
    let id = e.target.id;
    if (key === "Enter" && tagName === "INPUT") {
      let text = e.target.value;

      if (id === "bk_ccode") {
        modal.style.display = "block";
      } else if (id === "bk_acode") {
        modal.style.display = "block";
      }
    }
  });
});
