//화면에서 등록한 댓글내용을 컨트롤러로 전송 -> DB전송

//수정 버튼 클릭 확인 변수
let flag = false;
//수정 버튼이 눌린 댓글의 rno
let clickRno=0;

//비동기식 함수 생성
//댓글 저장 함수
async function postReplyToServer(reData) {
	try {
		//데이터를 보낼 경로
		const url = "/re/post";
		//요청에 대한 설정
		const config = {
			method: 'post',
			header: {
				//요청 본문의 데이터 형식 = JSON
				'content-Type': 'application/json; charset=utf-8;'
			},
			//JSON형태의 문자열로 변환
			body: JSON.stringify(reData)
		};

		console.log(">>> reDate > " + reData);
		//resp = url을 돌고 나서 나온 결과가 리턴됨. 즉, isOk값이 들어옴. 
		const resp = await fetch(url, config); // -> 여기서 controller로 이동함.
		const result = await resp.text();
		console.log(">>> resp > " + resp);
		console.log(">>> result > " + result);

		//0,1 값을 리턴함.
		return result;

	} catch (error) {
		console.log(error);
	}
}
//댓글 리스트 가져오기
async function getRelyListFromServer(bno) {
	try {
		const resp = await fetch('/re/list/' + bno);
		const reList = await resp.json(); // 댓글 객체가 리턴됨.
		return reList;
	} catch (e) {
		console.log(e);
	}
}

//댓글 리스트 화면에 뿌려주기
function spreadRelyList(result) {
	let content = '';
	let btn = '';
	console.log(result);
	let div = document.getElementById('accordionExample');
	
	//댓글 리셋
	div.innerHTML='';
	
	for (let i = 0; i < result.length; i++) {

		//수정 버튼이 누렸다면, input 태그로...아니면 label로  내용 표시.
		if (flag && clickRno==result[i].rno) {
			content = `<input type="text" class="form-control" id="reText1" value="${result[i].content}"/>`;
			btn = `<button type="button" data-rno="${result[i].rno}" data-writer="${result[i].user_id}" class="btn btn-sm btn-outline-warning reModDone">수정완료</button>
				<button type="button" data-rno="${result[i].rno}" data-writer="${result[i].user_id}" class="btn btn-sm btn-outline-danger reDelBtn">삭제</button>`;

		}
		else {
			content = `<label class="form-control" id="reText1">${result[i].content}</label><br>`;
			btn = `<button type="button" data-rno="${result[i].rno}" data-writer="${result[i].user_id}" class="btn btn-sm btn-outline-warning reModBtn">수정</button>
				<button type="button" data-rno="${result[i].rno}" data-writer="${result[i].user_id}" class="btn btn-sm btn-outline-danger reDelBtn">삭제</button>`;
		}
		if(user != result[i].user_id){
			btn='';
		}
		
		let html = `<div class="accordion-item">`;
		html += `<h2 class="accordion-header" id="heading${i}">`;
		html += `<button class="accordion-button" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapse${i}"
					aria-expanded="true" aria-controls="collapse${i}">
					${result[i].rno},${result[i].user_id}</button>
			</h2>`;
		html += `<div id="collapse${i}" class="accordion-collapse collapse show"
				aria-labelledby="heading${i}" data-bs-parent="#accordionExample">
				<div class="accordion-body">`;
		html += btn;
		html += content;
		html += `${result[i].reg_date}
				</div>
			</div>
		</div>`;
		div.innerHTML += html;

	}
}

//댓글 출력
function printReplyList(bno) {
	getRelyListFromServer(bno).then(result => {
		console.log(result);
		if (result.length > 0) {
			spreadRelyList(result);
		}
		else {
			console.log("댓글 없음");
			let div = document.getElementById('accordionExample');
			div.innerText = "댓글이 없습니다.";
		}
	});
}

async function removeReplyFromServer(rnoVal) {
	try {
		const url = '/re/remove?rnoVal=' + rnoVal;
		const config = {
			method: 'post'
		}
		const resp = await fetch(url, config);
		const result = await resp.text(); //isOk
		return result;
	} catch (e) {
		console.log(e);
	}
}

async function updateReplyFromServer(rnoVal, reText1, writer) {
	try {
		const url = "/re/modify";
		const config = {
			method: "post",
			headers: {
				'Content-Type': 'application/json; charset=utf-8'
			},
			body: JSON.stringify({ rno: rnoVal, content: reText1, user_id: writer })
		}

		const resp = await fetch(url, config);
		const result = await resp.text();
		return result;
	} catch (e) {

	}
}

//화면 어딜 눌러도 동작함.
document.addEventListener('click', (e) => {
	console.log(e.target.classList);

	//수정 버튼 눌렀을 때
	if (e.target.classList.contains('reModBtn')) {
		flag = true;
		clickRno=e.target.dataset.rno;
		printReplyList(bnoVal);
	}

	//수정완료 버튼 눌렀을 때
	if (e.target.classList.contains('reModDone')) {
		let rnoVal = e.target.dataset.rno;
		console.log(rnoVal);

		//나랑 가장 가까이에 있는 div를 찾아줘.
		let div = e.target.closest('div');
		//getElementId로 대체가능.
		let reText1 = div.querySelector('#reText1').value;

		let writer = e.target.dataset.writer;
		console.log(">>writer > " + writer);

		updateReplyFromServer(rnoVal, reText1, writer).then(result =>{
			if(result>0){
				alert("댓글 수정 완료~");
				flag=false;
				printReplyList(bnoVal);
			}else{
				alert("댓글 수정 실패~");
			}
		})

	}  
	
	//삭제 버튼을 눌렀을 때
	if (e.target.classList.contains('reDelBtn')) {
		let rnoVal = e.target.dataset.rno;
		console.log(rnoVal);
		removeReplyFromServer(rnoVal).then(result => {
			if (result > 0) {
				alert('댓글 삭제 완료!');
				printReplyList(bnoVal);
			}
		})
	}
});



//댓글 저장 버튼 클릭시 함수
document.getElementById('reAddBtn').addEventListener('click', () => {
	const retext = document.getElementById('reText').value;
	console.log(retext);
	if (retext == null || retext == "") {
		alert('댓글을 입력해주세요!')
		return false;
	} else {
		let reData = {
			bno: bnoVal,
			user_id: document.getElementById('id').value,
			content: retext
		};

		//이 부분 이해가 안됨.. then을 사용하는법...
		//비동기는 무조건 프로미스의 형태로 리턴함.
		//then을 써야 return값을 받을 수 있따??
		postReplyToServer(reData).then(result => {
			//js특징으로 인해서 형변환 없이 비교가 가능함.
			if (result > 0) {
				alert("댓글 등록 성공!!!");
				document.getElementById('reText').value = "";
			}
			printReplyList(reData.bno);
		});
	}
});