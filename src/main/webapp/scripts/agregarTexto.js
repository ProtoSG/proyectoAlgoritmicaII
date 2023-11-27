document.addEventListener("DOMContentLoaded", function () {
    const questionsContainer = document.getElementById("questions-container");
    const addQuestionButton = document.getElementById("add-question");
    const cantidadPreguntas = document.getElementById("cantidadPreguntas");
    
    let questionCounter = 1;  
    function createInputElement(type, name, placeholder) {
        const input = document.createElement("input");
        input.setAttribute("type", type);
        input.setAttribute("name", name);
        input.setAttribute("class", "h-12 block w-full rounded-md border-0 py-1.5 pl-2 pr-20 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6");
        input.setAttribute("placeholder", placeholder);
        input.required = true;
        return input;
    }

    function createLabelElement(forAttr, textContent) {
        const label = document.createElement("label");
        label.setAttribute("for", forAttr);
        label.setAttribute("class", "text-2xl block text-sm font-medium leading-6 text-gray-900");
        label.textContent = textContent;
        return label;
    }

    function createAlternativeButton(newDivAlternative, questionCounter, cantidadAlternativas) {
        let alternativeCounter = 2;
        const alternativeButton = document.createElement("button");
        alternativeButton.setAttribute("type", "button");
        alternativeButton.setAttribute("class", "mb-2 text-sm text-blue-700 hover:underline focus:outline-none add-alternative-btn");
        alternativeButton.textContent = "Agregar Alternativa";
        alternativeButton.addEventListener("click", function () {
            const newAlternativeInput = createInputElement("text", `alternative${questionCounter}_${alternativeCounter}`, "Nueva Alternativa");
            newDivAlternative.appendChild(newAlternativeInput);
            cantidadAlternativas.value = alternativeCounter;
            alternativeCounter++;
        });
        return alternativeButton;
    }

    function createDivElement(id){
        const div = document.createElement("div");
        div.setAttribute("id", id);
        div.setAttribute("class", "my-2");
        return div;
    }

    addQuestionButton.addEventListener("click", function () {
        
        
        const newDivQuestion = createDivElement("question-container");
        const newDivAlternatives = createDivElement("alternatives-container");
        const newDivAlternative = createDivElement("alternative-container");
        const newDivCorrectAnswer = createDivElement("correctAnswer-container");
        const newDivReason = createDivElement("reason-container");
        
        const newQuestionLabel = createLabelElement("question", `Pregunta ${questionCounter}`);
        const newQuestionInput = createInputElement("text", `question${questionCounter}`, "Nueva Pregunta");
        
        newDivQuestion.append(newQuestionLabel);
        newDivQuestion.append(newQuestionInput);
        
        const newAlternativeLabel = createLabelElement("alternative", "Alternativas");
        const newAlternativeInput = createInputElement("text", `alternative${questionCounter}_1`, "Nueva Alternativa");
        
        newDivAlternative.append(newAlternativeInput);
        
        const cantidadAlternativas = document.createElement("input");
        cantidadAlternativas.setAttribute("type", "text");
        cantidadAlternativas.setAttribute("name", `cantidadAlternativas${questionCounter}`);
        cantidadAlternativas.value = 1; 
        cantidadAlternativas.hidden = true;
        
        const addAlternativeButton = createAlternativeButton(newDivAlternative, questionCounter, cantidadAlternativas);
        
        newDivAlternatives.append(cantidadAlternativas);
        newDivAlternatives.append(newAlternativeLabel);
        newDivAlternatives.append(newDivAlternative);
        newDivAlternatives.append(addAlternativeButton);
        
        const newCorrectAnswerLabel = createLabelElement("correctAnswer", "Respuesta Correcta");
        const newCorrectAnswerInput = createInputElement("text", `correctAnswer${questionCounter}`, "Respuesta Correcta");
        
        newDivCorrectAnswer.append(newCorrectAnswerLabel);
        newDivCorrectAnswer.append(newCorrectAnswerInput);
        
        const newReasonLabel = createLabelElement("reason", "Razonamiento");
        const newReasonInput = createInputElement("text", `reason${questionCounter}`, "Razon");
        
        newDivReason.append(newReasonLabel);
        newDivReason.append(newReasonInput);
        
        questionsContainer.appendChild(newDivQuestion);
        questionsContainer.appendChild(newDivAlternatives);
        questionsContainer.appendChild(newDivCorrectAnswer);
        questionsContainer.appendChild(newDivReason);
        
        
        cantidadPreguntas.value = questionCounter;
        
        questionCounter++;
        
    });
});
