from datetime import datetime

def calculate_balance(principal, annual_rate, start_date, end_date):
    """
    Calculate the final balance with daily compound interest.
    
    Args:
        principal (float): Initial amount
        annual_rate (float): Annual interest rate (e.g., 0.05 for 5%)
        start_date (datetime): Start date
        end_date (datetime): End date
    
    Returns:
        float: Final balance
    """
    days = (end_date - start_date).days
    daily_rate = annual_rate / 365
    final_balance = principal * (1 + daily_rate) ** days
    
    return final_balance

result = calculate_balance(1000, 0.0201, datetime(2024, 3, 16), datetime.now())
print(f"Final balance: ${result:.2f}")