; ModuleID = '/home/yaos4/Lime26/input/Reindeer.c'
source_filename = "/home/yaos4/Lime26/input/Reindeer.c"
target datalayout = "e-m:e-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%struct.Reindeer_struct = type { i32, i32, i32, i32, %struct.Sleigh_struct* }
%struct.Sleigh_struct = type opaque

; Function Attrs: noinline nounwind optnone uwtable
define void @Reindeer_action1(%struct.Reindeer_struct*, i8*) #0 {
  %3 = alloca %struct.Reindeer_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Reindeer_struct* %0, %struct.Reindeer_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Reindeer_struct*, %struct.Reindeer_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Reindeer_struct, %struct.Reindeer_struct* %5, i32 0, i32 4
  %7 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %6, align 8
  %8 = load i8*, i8** %4, align 8
  call void @Sleigh_back(%struct.Sleigh_struct* %7, i8* %8)
  %9 = load %struct.Reindeer_struct*, %struct.Reindeer_struct** %3, align 8
  %10 = getelementptr inbounds %struct.Reindeer_struct, %struct.Reindeer_struct* %9, i32 0, i32 4
  %11 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %10, align 8
  %12 = load i8*, i8** %4, align 8
  call void @Sleigh_harness(%struct.Sleigh_struct* %11, i8* %12)
  %13 = load %struct.Reindeer_struct*, %struct.Reindeer_struct** %3, align 8
  %14 = getelementptr inbounds %struct.Reindeer_struct, %struct.Reindeer_struct* %13, i32 0, i32 4
  %15 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %14, align 8
  %16 = load i8*, i8** %4, align 8
  call void @Sleigh_pull(%struct.Sleigh_struct* %15, i8* %16)
  ret void
}

declare void @Sleigh_back(%struct.Sleigh_struct*, i8*) #1

declare void @Sleigh_harness(%struct.Sleigh_struct*, i8*) #1

declare void @Sleigh_pull(%struct.Sleigh_struct*, i8*) #1

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"}
