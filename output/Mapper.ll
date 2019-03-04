; ModuleID = 'Mapper.c'
source_filename = "Mapper.c"
target datalayout = "e-m:o-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-apple-macosx10.12.0"

%struct.Mapper_struct = type { i32, i32, i32, i32, %struct.Reducer_struct*, i32, i32, i32 }
%struct.Reducer_struct = type opaque

; Function Attrs: norecurse nounwind optsize ssp uwtable
define void @Mapper_map(i32, %struct.Mapper_struct* nocapture) local_unnamed_addr #0 {
  %3 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %1, i64 0, i32 6
  store i32 %0, i32* %3, align 4, !tbaa !3
  %4 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %1, i64 0, i32 5
  store i32 1, i32* %4, align 8, !tbaa !9
  ret void
}

; Function Attrs: nounwind optsize ssp uwtable
define void @Mapper_doMap(%struct.Mapper_struct* nocapture) local_unnamed_addr #1 {
  %2 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %0, i64 0, i32 7
  %3 = load i32, i32* %2, align 8, !tbaa !10
  %4 = and i32 %3, 1
  %5 = icmp eq i32 %4, 0
  %6 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %0, i64 0, i32 6
  %7 = load i32, i32* %6, align 4, !tbaa !3
  %8 = mul nsw i32 %7, %7
  %9 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %0, i64 0, i32 4
  %10 = load %struct.Reducer_struct*, %struct.Reducer_struct** %9, align 8, !tbaa !11
  br i1 %5, label %11, label %13

; <label>:11:                                     ; preds = %1
  %12 = tail call i32 (i32, %struct.Reducer_struct*, ...) bitcast (i32 (...)* @Reducer_reduce1 to i32 (i32, %struct.Reducer_struct*, ...)*)(i32 %8, %struct.Reducer_struct* %10) #3
  br label %15

; <label>:13:                                     ; preds = %1
  %14 = tail call i32 (i32, %struct.Reducer_struct*, ...) bitcast (i32 (...)* @Reducer_reduce2 to i32 (i32, %struct.Reducer_struct*, ...)*)(i32 %8, %struct.Reducer_struct* %10) #3
  br label %15

; <label>:15:                                     ; preds = %13, %11
  %16 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %0, i64 0, i32 5
  store i32 1, i32* %16, align 8, !tbaa !9
  ret void
}

; Function Attrs: optsize
declare i32 @Reducer_reduce1(...) local_unnamed_addr #2

; Function Attrs: optsize
declare i32 @Reducer_reduce2(...) local_unnamed_addr #2

attributes #0 = { norecurse nounwind optsize ssp uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="true" "no-frame-pointer-elim-non-leaf" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { nounwind optsize ssp uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="true" "no-frame-pointer-elim-non-leaf" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #2 = { optsize "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="true" "no-frame-pointer-elim-non-leaf" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #3 = { nounwind optsize }

!llvm.module.flags = !{!0, !1}
!llvm.ident = !{!2}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{i32 7, !"PIC Level", i32 2}
!2 = !{!"clang version 5.0.0 (tags/RELEASE_500/final)"}
!3 = !{!4, !5, i64 28}
!4 = !{!"Mapper_struct", !5, i64 0, !5, i64 4, !5, i64 8, !5, i64 12, !8, i64 16, !5, i64 24, !5, i64 28, !5, i64 32}
!5 = !{!"int", !6, i64 0}
!6 = !{!"omnipotent char", !7, i64 0}
!7 = !{!"Simple C/C++ TBAA"}
!8 = !{!"any pointer", !6, i64 0}
!9 = !{!4, !5, i64 24}
!10 = !{!4, !5, i64 32}
!11 = !{!4, !8, i64 16}
