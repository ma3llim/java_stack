from typing import Optional
from pydantic import BaseModel, Field

class Expense(BaseModel):
    amount: Optional[str] = Field(
        default=None,
        description="Transaction amount"
    )

    merchant: Optional[str] = Field(
        default=None,
        description="Merchant name"
    )

    currency: Optional[str] = Field(
        default=None,
        description="Transaction currency"
    )