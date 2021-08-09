
function openModal() {
    document.querySelector('#modal').style.display = 'flex';
}

function closeModal() {
    document.querySelector('#modal').style.display = 'none';
}
const modalElem = document.getElementById('modal');
modalElem.addEventListener('click',(e)=>{
    e.target === modalElem ? closeModal() : false;
})
