from datetime import datetime, timedelta

def count_friday_13th(start_date, end_date):
    """
    Calculate the number of Friday the 13th occurrences between two dates.
    
    Args:
        start_date (datetime): Start date
        end_date (datetime): End date
    
    Returns:
        int: Number of Friday the 13th occurrences
    """
    count = 0
    
    # Start from the first day of the month containing start_date
    current = start_date.replace(day=1)
    
    while current <= end_date:
        # Check if the 13th of current month is a Friday and within date range
        thirteenth = current.replace(day=13)
        if thirteenth.weekday() == 4 and start_date <= thirteenth <= end_date:  # Friday is weekday 4
            count += 1
        
        # Move to next month
        if current.month == 12:
            current = current.replace(year=current.year + 1, month=1)
        else:
            current = current.replace(month=current.month + 1)
    
    return count

# Example usage:
start = datetime(2000, 1, 1)
end = datetime(2019, 12, 31)
result = count_friday_13th(start, end)
print(f"Friday the 13th occurrences: {result}")