import os
from dotenv import load_dotenv
from langchain_core.prompts import ChatPromptTemplate
from langchain_mistralai import ChatMistralAI
from service.Expense import Expense

load_dotenv()

class LLMService:
    def __init__(self):
        self.prompt = ChatPromptTemplate.from_messages(
            [
                (
                    "system",
                    "You are an expert extraction algorithm. "
                    "Only extract relevant information from the text. "
                    "If you do not know the value of an attribute asked to extract, "
                    "return null for the attribute's value."
                ),
                ("human", "{text}")
            ]
        )
        self.llm = ChatMistralAI(
            api_key=os.getenv("MISTRAL_API_KEY"),
            model="mistral-large-latest",
            temperature=0
        )

        self.runnable = (
            self.prompt | self.llm.with_structured_output(Expense)
        )

    def run_llm(self, text):
        return self.runnable.invoke({"text": text}).model_dump();