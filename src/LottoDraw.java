public class LottoDraw {
    public static void main(String[] args) {

        // Step 1: 生成 1 到 40 之间的彩票号码
        StrLinkedList lotteryNumbers = StrLinkedList.generateLotteryNumbers();
        System.out.print("彩票号码lottery numbers：");
        lotteryNumbers.print();  // 打印所有 40 个彩票号码

        // Step 2: 从中随机选择 6 个中奖号码
        StrLinkedList winningNumbers = StrLinkedList.pickWinningNumbers(lotteryNumbers);
        System.out.print("中奖号码：");
        winningNumbers.print();  // 打印 6 个中奖号码

        // Step 3: 生成 100 张彩票并计算总奖池
        //100 tickets
        double totalPrizePool = 0.0;
        double totalSales = 0.0;
        int numTickets = 100;
        for (int i = 0; i < numTickets; i++) {
            StrLinkedList ticket = StrLinkedList.generateTicket(lotteryNumbers);
            int matches = StrLinkedList.calculateMatches(ticket, winningNumbers);
            double prize = StrLinkedList.calculatePrize(matches);
            totalPrizePool += prize;
            totalSales += 10.00;  //he cost of a ticket=10 每张彩票售价 $10.00
        }

        // Step 4: 计算并显示总销售额和利润
        double profit = totalSales - totalPrizePool;
        System.out.println("\n100 张彩票的总销售额：" + totalSales);
        System.out.println("总奖池totalPrizePool：" + totalPrizePool);
        System.out.println("筹款利润fundraising profit：" + profit);
    }
}
