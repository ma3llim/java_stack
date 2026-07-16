from service.LLMService import LLMService

class MessageService:
    def __init__(self):
        self.llm_service = LLMService()
    
    def process_message(self, message):
        return self.llm_service.run_llm(message)